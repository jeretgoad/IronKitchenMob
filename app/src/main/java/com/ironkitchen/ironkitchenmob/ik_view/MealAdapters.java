package com.ironkitchen.ironkitchenmob.ik_view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.ironkitchen.ironkitchenmob.R;
import com.ironkitchen.ironkitchenmob.ik_data.MealTabOjects;
import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPicker;
import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPickerListener;
import java.util.ArrayList;


/**
 * Created by user on 2/22/18.
 */


// Adapter for RecyclerView inside meal_food_choose_selection.xml

class InnerSelectionsRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<MealTabOjects> theseSelections;
    private  int selectionRowIndex = -1;
    private InnerRVAdapter innerParentAdapter;
    private boolean scrollState;
    public InnerSelectionsRVAdapter(InnerRVAdapter parent){
        this.innerParentAdapter = parent;
        this.scrollState = true;
    }


    public void setScrollState(boolean state){
        scrollState = state;
        notifyItemChanged(selectionRowIndex);
    }

    public boolean getScrollState(){
        return scrollState;
    }
    public void setMealSelectionsObjects(ArrayList<MealTabOjects> currSelections)
    {
        if(this.theseSelections != currSelections)
        {
            this.theseSelections = currSelections;
            notifyItemChanged(selectionRowIndex);
        }
    }

    public void setSelectionsIndex(int index)
    {

        this.selectionRowIndex = index;
    }

    public class ThisSelectionsViewHolder extends RecyclerView.ViewHolder{
        private TextView selectionLabel, selectionPrice, quantity;
        private ScrollableNumberPicker quantitySNP;
        private int startNP = 0;
        private  final View parentView;
        private InnerRVAdapter innerRVAdapter;
        public ThisSelectionsViewHolder(View view)
        {
            super(view);
            parentView = (View) view.getParentForAccessibility();
            selectionLabel = (TextView) view.findViewById(R.id.selectionText);
            selectionPrice = (TextView) view.findViewById(R.id.selectionPrice);
            quantity = (TextView) view.findViewById(R.id.quantityText);
            quantitySNP = (ScrollableNumberPicker) view.findViewById(R.id.scrollNP);
        }

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View selectionView = LayoutInflater.from(context).inflate(R.layout.meal_food_choose_selection, parent, false);
        ThisSelectionsViewHolder selectionHolder = new ThisSelectionsViewHolder(selectionView);
        return selectionHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ThisSelectionsViewHolder selectionHolder = (ThisSelectionsViewHolder) holder;
        selectionHolder.selectionLabel.setText(theseSelections.get(position).getSeasoning());
        String priceFormat = String.format("%.2f", theseSelections.get(position).getPrice());
        selectionHolder.selectionPrice.setText("$" + priceFormat);
        if(getItemCount() > 2 && getItemCount() <= 4)
        {
            selectionHolder.selectionLabel.setTextSize(15);
            if(selectionHolder.selectionLabel.length() > 5)
            {
                selectionHolder.selectionLabel.setTextSize(13);
            }
            selectionHolder.selectionPrice.setTextSize(14);
            selectionHolder.quantity.setTextSize(13);
        }
        else if(getItemCount() > 4)
        {
            selectionHolder.selectionLabel.setTextSize(13);
            selectionHolder.selectionPrice.setTextSize(12);
            selectionHolder.quantity.setTextSize(11);
        }
        if(getScrollState()) {
            selectionHolder.quantitySNP.setListener(new ScrollableNumberPickerListener() {
                @Override
                public void onNumberPicked(int value) {
                    if (value > selectionHolder.startNP) {
                        theseSelections.get(position).addToTotal(theseSelections.get(position).getPrice());
                        if (!innerParentAdapter.getInnerSelChange()) {
                            innerParentAdapter.setInnerSelChange(true);
                        }
                    } else if (value < selectionHolder.startNP) {
                        theseSelections.get(position).subtractFromTotal(theseSelections.get(position).getPrice());
                    }
                    selectionHolder.startNP = value;
                    innerParentAdapter.notifyDataSetChanged();
                }
            });
        }
        else{
            selectionHolder.quantitySNP.setEnabled(false);
        }

    }

    @Override
    public int getItemCount() {
        return this.theseSelections.size();
    }
}

// Adapter for RecyclerView in meal_food_panal.xml

class InnerRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static ArrayList<MealTabOjects> mealObjects;
    private int mRowIndex = -1;
    private final Context innerContext;
    private static InnerRVAdapter thisInnerRVAdapter;
    private static boolean innerSelChange;

    public InnerRVAdapter(Context context) {
            innerContext = context;
            this.thisInnerRVAdapter = this;
        }

    public void setMealObjects(ArrayList<MealTabOjects> mealObjects) {
        if(this.mealObjects != mealObjects){
            this.mealObjects = mealObjects;
            notifyDataSetChanged();
        }
    }
    public void setInnerRCIndex(int index){
        mRowIndex = index;
    }

    public void setInnerSelChange(boolean change){
        innerSelChange = change;
    }

    public boolean getInnerSelChange(){
        return innerSelChange;
    }

    public static class ThisPanalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView foodImage;
        private TextView foodImageText, total;
        private Button addToCartButton, editCartItemsButton;
        private InnerSelectionsRVAdapter innerSelectionsAdapter;
        private  RecyclerView selectionRV;
        private GridLayoutManager glm;
        private Context context;


        public ThisPanalViewHolder(View itemView){
            super(itemView);
            context = itemView.getContext();
            foodImage = (ImageView) itemView.findViewById(R.id.mealChoiceItem);
            foodImageText = (TextView) itemView.findViewById(R.id.mealChoiceImageTitle);
            selectionRV = (RecyclerView) itemView.findViewById(R.id.mealChoiceSelectionRV);
            innerSelectionsAdapter = new InnerSelectionsRVAdapter(thisInnerRVAdapter);
            selectionRV.setAdapter(innerSelectionsAdapter);
            total = (TextView) itemView.findViewById(R.id.totalPrice);
            addToCartButton = (Button) itemView.findViewById(R.id.addToCartButton);
            editCartItemsButton = (Button) itemView.findViewById(R.id.editCartItemsButton);
            addToCartButton.setOnClickListener(this);
            editCartItemsButton.setOnClickListener(this);
            disableButton(addToCartButton);
            disableButton(editCartItemsButton);
        }

        @Override
        public void onClick(View view) {
            if(view == addToCartButton){
                enableButton(editCartItemsButton);
                disableButton(addToCartButton);
                innerSelectionsAdapter.setScrollState(false);
            }
            else if(view == editCartItemsButton){
                disableButton(editCartItemsButton);
                innerSelectionsAdapter.setScrollState(true);
                enableButton(addToCartButton);
            }
        }

        public void enableButton(Button enableB)
        {
            enableB.setAlpha(1f);
            enableB.setEnabled(true);
        }

        public void disableButton(Button disableB){
            disableB.setAlpha(.2f);
            disableB.setEnabled(false);
        }

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.meal_food_choose, parent, false);;
        return new ThisPanalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder rawHolder, int position) {
        ThisPanalViewHolder holder = (ThisPanalViewHolder) rawHolder;
        Glide.with(holder.itemView.getContext()).load(mealObjects.get(position).imageID).into(holder.foodImage);
        holder.foodImageText.setText(mealObjects.get(position).mealType);
        if(mealObjects.get(position).mealType.length() < 11)
        {
            holder.foodImageText.setTextSize(25);
        }
        else if(mealObjects.get(position).mealType.length() >= 11 && mealObjects.get(position).mealType.length() < 15)
        {
            holder.foodImageText.setTextSize(24);
        }
        else if(mealObjects.get(position).mealType.length() >= 15 && mealObjects.get(position).mealType.length() < 20)
        {
            holder.foodImageText.setTextSize(22);
        }
        else if(mealObjects.get(position).mealType.length() >= 20 && mealObjects.get(position).mealType.length() <22)
        {
            holder.foodImageText.setTextSize(20);
        }
        else
        {
            holder.foodImageText.setTextSize(18);
        }
        int gridSize = mealObjects.get(position).getMealSelections().size();
        holder.glm = new GridLayoutManager(innerContext, gridSize);
        holder.selectionRV.setLayoutManager(holder.glm);
        holder.innerSelectionsAdapter.setMealSelectionsObjects(mealObjects.get(position).getMealSelections());
        holder.innerSelectionsAdapter.setSelectionsIndex(position);
        holder.total.setText("$" + mealObjects.get(position).getMealSelectionsTotal());
        if(!holder.addToCartButton.isEnabled() && getInnerSelChange() == true){
            holder.enableButton(holder.addToCartButton);
        }
    }

    @Override
    public int getItemCount() {
        return mealObjects.size();
    }
}

// Adapter for RecyclerView in fragment_meal_prep.xml

class OuterRVAdapter extends RecyclerView.Adapter<OuterRVAdapter.PanalViewHolder> {

    private final Context outContext;
    public static ArrayList<ArrayList<MealTabOjects>> mMealObjects;
    private static String[] stringPanal;
    private static RecyclerView innerRV;

    public static class PanalViewHolder extends RecyclerView.ViewHolder {
        public final TextView textPanal;
        private InnerRVAdapter innerAdapter;

        public PanalViewHolder(View view) {
            super(view);
            Context context = view.getContext();
            textPanal = (TextView) view.findViewById(R.id.textPanal);
            innerRV = (RecyclerView) view.findViewById(R.id.mealPrepChoiceRecView);
            innerRV.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            innerAdapter = new InnerRVAdapter(context);
            innerRV.setAdapter(innerAdapter);
        }
    }

    public OuterRVAdapter(Context context, ArrayList<ArrayList<MealTabOjects>> mealOjects, String[] panalTitle) {
        outContext = context;
        mMealObjects = mealOjects;
        stringPanal = panalTitle;
    }


    @Override
    public PanalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(outContext).inflate(R.layout.meal_food_panal, parent, false);
        return new PanalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PanalViewHolder holder, int position) {
        holder.textPanal.setText(stringPanal[position]);
        holder.innerAdapter.setMealObjects(mMealObjects.get(position));
        holder.innerAdapter.setInnerRCIndex(position);
    }

    @Override
    public int getItemCount() {
        return mMealObjects.size();
    }
}

class MealAdapters {
    public static Context context;
    private String[] panalTitles;
    public static ArrayList<ArrayList<MealTabOjects>> mealSections;
    public static OuterRVAdapter outAdapter;

    public MealAdapters(Context context){
        this.context = context;
        this.panalTitles = getPanalTitles();
        this.mealSections = getPanals();
        this.outAdapter = new OuterRVAdapter(this.context, this.mealSections, this.panalTitles);
    }

    public OuterRVAdapter getOuterAdapter(){
        return this.outAdapter;
    }

    /*public String[] getPanalTitles()
    {
        String[] panalTitlesTmp = new String[4];
        panalTitlesTmp[0] = "Proteins By The Pound";
        panalTitlesTmp[1] = "Carbs By The Pound";
        panalTitlesTmp[2] = "Vegetables By The Pound";
        panalTitlesTmp[3] = "Individual Meals";
        return panalTitlesTmp;
    }

    public ArrayList<ArrayList<MealTabOjects>> getPanals(){
        ArrayList<ArrayList<MealTabOjects>> thisList = new ArrayList<>();
        for(int i =0; i < 4; i++)
        {
            ArrayList<MealTabOjects> mealSelections = getMealTabObjectsList(i);
            thisList.add(mealSelections);
        }
        return thisList;
    }

    public ArrayList<MealTabOjects> getMealTabObjectsList(int panal){
        ArrayList<MealTabOjects> panalList = new ArrayList<>();
        if(panal == 0){
            MealTabOjects steak = new MealTabOjects("Steak", R.drawable.steak);
            steak.addMealTabObject("1 lbs", 12.00);
            steak.addMealTabObject("5 lbs", 50.00);
            panalList.add(steak);
            MealTabOjects turkey = new MealTabOjects("Turkey", R.drawable.turkey);
            turkey.addMealTabObject("1 lbs", 11.00);
            turkey.addMealTabObject("5 lbs", 45.00);
            panalList.add(turkey);
            MealTabOjects cb = new MealTabOjects("Chicken Breast", R.drawable.chic_breast);
            cb.addMealTabObject("1 lbs Chipotle/dry", 10.00);
            cb.addMealTabObject("5 lbs Chipotle/dry", 40.00);
            cb.addMealTabObject("1 lbs Teriyaki/wet", 11.00);
            cb.addMealTabObject("5 lbs Teriyaki/wet",45.00);
            panalList.add(cb);
            MealTabOjects shredChic = new MealTabOjects("Shredded Chicken", R.drawable.shred_chicken);
            shredChic.addMealTabObject("1 lbs", 10.00);
            shredChic.addMealTabObject("5 lbs", 40.00);
            panalList.add(shredChic);
            return panalList;
        }
        else if(panal == 1){
            MealTabOjects redPot = new MealTabOjects("Red Potatoes", R.drawable.red_pot);
            redPot.addMealTabObject("1 lbs", 7.00);
            redPot.addMealTabObject("5 lbs", 30.00);
            redPot.addMealTabObject("1 lbs Cajun", 7.99);
            redPot.addMealTabObject("5 lbs Cajun",35.00);
            panalList.add(redPot);
            MealTabOjects jasRice = new MealTabOjects("Jasmine Rice", R.drawable.jasmine_rice);
            jasRice.addMealTabObject("1 lbs", 5.00);
            jasRice.addMealTabObject("5 lbs", 20.00);
            panalList.add(jasRice);
            MealTabOjects sweetPot = new MealTabOjects("Sweet Potatoes", R.drawable.sweet_potatoes);
            sweetPot.addMealTabObject("1 lbs",7.00);
            sweetPot.addMealTabObject("5 lbs", 30.00);
            sweetPot.addMealTabObject("1 lbs B. Suger Cinnimon", 7.99);
            sweetPot.addMealTabObject("1 lbs Cajun",7.99);
            panalList.add(sweetPot);
            return panalList;
        }
        else if(panal == 2)
        {
            MealTabOjects vegMed = new MealTabOjects("Vegetable Medley", R.drawable.veg_medley);
            vegMed.addMealTabObject("1 lbs", 8.00);
            vegMed.addMealTabObject("5 lbs",35.00);
            panalList.add(vegMed);
            MealTabOjects zucSquash = new MealTabOjects("Zucchini / Squash Mix", R.drawable.zuc_squash_mix);
            zucSquash.addMealTabObject("1 lbs",8.00);
            zucSquash.addMealTabObject("5 lbs",35.00);
            panalList.add(zucSquash);
            MealTabOjects broccoli = new MealTabOjects("Broccoli", R.drawable.broccoli);
            broccoli.addMealTabObject("1 lbs", 8.00);
            broccoli.addMealTabObject("5 lbs", 35.00);
            panalList.add(broccoli);
            return panalList;
        }
        else {
            MealTabOjects tacoBowl = new MealTabOjects("Taco Bowl", R.drawable.taco_bowl);
            tacoBowl.addMealTabObject("Chicken",7.00);
            tacoBowl.addMealTabObject("Turkey",7.00);
            panalList.add(tacoBowl);
            MealTabOjects bufChicRice = new MealTabOjects("Buffalo Chicken Rice", R.drawable.buff_chic_rice);
            bufChicRice.addMealTabObject("Buffalo Chicken Rice", 8.00);
            panalList.add(bufChicRice);
            MealTabOjects chicPeppers = new MealTabOjects("Chicken Peppers", R.drawable.chicken_peppers);
            chicPeppers.addMealTabObject("Chicken Peppers", 8.00);
            panalList.add(chicPeppers);
            return panalList;
        }

    }*/
}


