package com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.activity.exam;

import android.content.Context;
import android.content.Intent;
import android.media.ExifInterface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.R;
import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.adapter.ListenGuessAdapter;
import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.customclasses.AppControl;
import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.customclasses.Constant;
import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.model.LearningDataModel;
import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ListenGuessActivity extends AppCompatActivity {

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_listen_guess);
        getSupportActionBar().hide();
        context = this;
        initDefine();

    }

    ImageView iVQuestion;
    TextView tvName;
    int correctPosition;
    Random random;

    TextView txtTitleSubHome;
    private void initDefine() {
        iVQuestion = findViewById(R.id.iVQuestion);
        rv_exam = findViewById(R.id.rv_exam);
        tvName = findViewById(R.id.tvName);
        txtTitleSubHome = findViewById(R.id.txtTitleSubHome);

        Intent intent = getIntent();
        prepareDataForLearning(intent.getIntExtra("categoryPosition", 0));
        txtTitleSubHome.setText(intent.getStringExtra("SubCate"));
        getRandomArray();
    }


    private void getRandomArray() {
        random = new Random();
        examQuestionAnswerList = new ArrayList<>();
        correctPosition = random.nextInt(learningDataModelArrayList.size());
        if (Utils.getPref(Constant.SOUND,true)) {
            AppControl.textToSpeech.speak(learningDataModelArrayList.get(correctPosition).showTitle, TextToSpeech.QUEUE_FLUSH, null);
        }
        tvName.setText(learningDataModelArrayList.get(correctPosition).showTitle);
        Glide.with(context)
                .load(R.drawable.btn_sound)
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(iVQuestion);
        iVQuestion.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce_amn));
        examQuestionAnswerList.add(learningDataModelArrayList.get(correctPosition));
        do {
            int number = random.nextInt(learningDataModelArrayList.size());
            if (!examQuestionAnswerList.contains(learningDataModelArrayList.get(number))) {
                examQuestionAnswerList.add(learningDataModelArrayList.get(number));
            }
        }
        while (examQuestionAnswerList.size() != 4);
        Collections.shuffle(examQuestionAnswerList);
        setRvAdapter();
    }

    public void onClickSound(View view) {
        if (Utils.getPref(Constant.SOUND,true)) {
            AppControl.textToSpeech.speak(learningDataModelArrayList.get(correctPosition).showTitle, TextToSpeech.QUEUE_FLUSH, null);
        }
    }




    RecyclerView rv_exam;
    public ArrayList<LearningDataModel> examQuestionAnswerList;
    ListenGuessAdapter listenGuessAdapter;

    private void setRvAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
        rv_exam.setLayoutManager(gridLayoutManager);
        listenGuessAdapter = new ListenGuessAdapter(context, examQuestionAnswerList, learningDataModelArrayList.get(correctPosition));
        rv_exam.setAdapter(listenGuessAdapter);
    }

    public void onClickNext(View view) {
        getRandomArray();
    }


    public void onClickPrev(View view) {
        getRandomArray();
    }






    public void onClickBack(View view) {
        finish();
    }

    ArrayList<LearningDataModel> learningDataModelArrayList;

    public void prepareDataForLearning(int i2) {
        if (i2 == 0) {
            learningDataModelArrayList = new ArrayList();
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newa11, "A for Apple", "Apple"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newb, "B for Ball", "Ball"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newc, "C for Cat", "Cat"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newd, "D for Dog", "Dog"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newe, "E for Elephant", "Elephant"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newf, "F for Fish", "Fish"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newg, "G for Goat", "Goat"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newh1, "H for Horse", "Horse"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newi, "I for Ice cream", "Ice cream"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newj, "J for Joker", "Joker"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newk, "K for Kite", "Kite"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newl, "L for Lion", "Lion"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newm, "M for Monkey", "Monkey"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newn, "N for Nest", "Nest"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newo, "O for Orange", "Orange"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newp, "P for Parrot", "Parrot"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newq, "Q for Queen", "Queen"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newr, "R for Rabbit", "Rabbit"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.news, "S for Sun", "Sun"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newt, "T for Train", "Train"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newu, "U for Umbrella", "Umbrella"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newv, "V for Violin", "Violin"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.neww, "W for Watch", "Watch"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newx, "X for Xylophone", "Xylophone"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newy2, "Y for Yak", "Yak"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newz, "Z for Zebra", "Zebra"));
        } else if (i2 == 1) {
            learningDataModelArrayList = new ArrayList();
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.zero_0, "Zero", "Zero"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.one_1, "One", "One"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.two_2, "Two", "Two"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.three_3, "Three", "Three"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.four_4, "Four", "Four"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.five_5, "Five", "Five"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.six_6, "Six", "Six"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.seven_7, "Seven", "Seven"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.eight_8, "Eight", "Eight"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.nine_9, "Nine", "Nine"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.ten_10, "Ten", "Ten"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.eleven_11, "Eleven", "Eleven"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.twelve_12, "Twelve", "Twelve"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.thirteen_13, "Thirteen", "Thirteen"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.fourteen_14, "Fourteen", "Fourteen"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.fifteen_15, "Fifteen", "Fifteen"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.sixteen_16, "Sixteen", "Sixteen"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.seventeen_17, "Seventeen", "Seventeen"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.eighteen_18, "Eighteen", "Eighteen"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.nineteen_19, "Nineteen", "Nineteen"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.twenty_20, "Twenty", "Twenty"));
        } else if (i2 == 2) {
            learningDataModelArrayList = new ArrayList();

            learningDataModelArrayList.add(new LearningDataModel(R.drawable.green1, "Green", "Green"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.pink1, "Pink", "Pink"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.red1, "Red", "Red"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.black1, "Black", "Black"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.aqua1, "Aqua", "Aqua"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.blue1, "Blue", "Blue"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.brown1, "Brown", "Brown"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.orange1, "orange", "Slate"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.violet1, "Violet", "Violet"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.white1, "White", "White"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.yellow1, "Yellow", "Yellow"));
        } else if (i2 == 11) {
            learningDataModelArrayList = new ArrayList();
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.circle, "Circle", "Circle"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.square, "Square", "Square"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.decagon, "Decagon", "Decagon"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.ellipse, "Ellipse", "Ellipse"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.hexagon, "Hexagon", "Hexagon"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.triangle, "Triangle", "Triangle"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.octagon, "Octagon", "Octagon"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.parallelogram, "Parallelogram", "Parallelogram"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.pentagon, "Pentagon", "Pentagon"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.rectangle, "Rectangle", "Rectangle"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.rhombus, "Rhombus", "Rhombus"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.right_triangle, "Right Triangle", "Right Triangle"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.trapezoid, "Trapezoid", "Trapezoid"));
        } else if (i2 == 12) {
            learningDataModelArrayList = new ArrayList();
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.bear, "Bear", "Bear"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.bison, "Bison", "Bison"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.black_leopard, "Black Leopard", "Black Leopard"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.cheetah, "Cheetah", "Cheetah"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.chimpanzee, "Chimpanzee", "Chimpanzee"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.chipmuck, "Chipmuck", "Chipmuck"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.cougar, "Cougar", "Cougar"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.deer, "Deer", "Deer"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.elephant, "Elephant", "Elephant"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.fox, "Fox", "Fox"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.giraffe, "Giraffe", "Giraffe"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.gorilla, "Gorilla", "Gorilla"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.hedgehog, "Hedgehog", "Hedgehog"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.hippopotamus, "Hippopotamus", "Hippopotamus"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.hyena, "Hyena", "Hyena"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.jackal, "Jackal", "Jackal"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.jaguar, "Jaguar", "Jaguar"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.kangaroo, "Kangaroo", "Kangaroo"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.koala_bear, "Koala Bear", "Koala Bear"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.lion, "Lion", "Lion"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.meerkat, "Meerkat", "Meerkat"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.mongoose, "Mongoose", "Mongoose"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.monkey, "Monkey", "Monkey"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.opossum, "Opossum", "Opossum"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.otter, "Otter", "Otter"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.panda, "Panda", "Panda"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.polar_bear, "Polar Bear", "Polar Bear"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.porcupine, "Porcupine", "Porcupine"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.raccoon, "Raccoon", "Raccoon"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.red_panda, "Red Panda", "Red Panda"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.rhinoceros, "Rhinoceros", "Rhinoceros"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.scimitar_oryx, "Scimitar Oryx", "Scimitar Oryx"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.squirrel, "Squirrel", "Squirrel"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.tiger, "Tiger", "Tiger"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.wolf, "Wolf", "Wolf"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.wombat, "Wombat", "Wombat"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.zebra, "Zebra", "Zebra"));
        } else if (i2 == 6) {
            learningDataModelArrayList = new ArrayList();
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.canary, "Canary", "Canary"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.crow, "Crow", "Crow"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.dove, "Dove", "Dove"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.duck, "Duck", "Duck"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.eagle, "Eagle", "Eagle"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.hoopoe, "Hoopoe", "Hoopoe"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.hornbill, "Hornbill", "Hornbill"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.kingfisher, "Kingfisher", "Kingfisher"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.kite, "Kite", "Kite"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.lapwing, "Lapwing", "Lapwing"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.mynah, "Mynah", "Mynah"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.nightingale, "Nightingale", "Nightingale"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.owl, "Owl", "Owl"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.parrot, "Parrot", "Parrot"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.peacock, "Peacock", "Peacock"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.peahen, "Peahen", "Peahen"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.pheasant, "Pheasant", "Pheasant"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.pigeon, "Pigeon", "Pigeon"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.puffin, "Puffin", "Puffin"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.quail, "Quail", "Quail"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.robin, "Robin", "Robin"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.sparrow, "Sparrow", "Sparrow"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.swallow, "Swallow", "Swallow"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.toucan, "Toucan", "Toucan"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.vulture, "Vulture", "Vulture"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.wagtail, "Wagtail", "Wagtail"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.waxwing, "Waxwing", "Waxwing"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.woodpecker, "Woodpecker", "Woodpecker"));
        } else if (i2 == 7) {
            learningDataModelArrayList = new ArrayList();
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.apple, "Apple", "Apple"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.apricot, "Apricot", "Apricot"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.avocado, "Avocado", "Avocado"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.blackberry, "Blackberry", "Blackberry"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.blackcurrant, "Blackcurrant", "Blackcurrant"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.blueberry, "Blueberry", "Blueberry"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.cherry, "Cherry", "Cherry"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.coconut, "Coconut", "Coconut"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.fig, "Fig", "Fig"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.grape, "Grape", "Grape"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.kiwi, "Kiwi", "Kiwi"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.lemon, "Lemon", "Lemon"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.lime, "Lime", "Lime"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.lychee, "Lychee", "Lychee"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.mango, "Mango", "Mango"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.nectarine, "Nectarine", "Nectarine"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.orange, "Orange", "Orange"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.papaya, "Papaya", "Papaya"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.passion, "Passion", "Passion"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.peach, "Peach", "Peach"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.pear, "Pear", "Pear"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.pineapple, "Pineapple", "Pineapple"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.plum, "Plum", "Plum"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.quince, "Quince", "Quince"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.raspberry, "Raspberry", "Raspberry"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.strawberry, "Strawberry", "Strawberry"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.watermelon, "Watermelon", "Watermelon"));
        } else if (i2 == 5) {
            learningDataModelArrayList = new ArrayList();
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.icon2, "फळ", "फळ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.apol, "आपोल", "आपोल"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.kele, "केळी", "केळे"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.amo, "आंबो", "आंबो"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.kaju, "काजू", "काजू"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.chiku, "चीकू", "चीकू"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.sita, "सीताफळ", "सीताफळ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.tori, "तोरींग", "तोरींग"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.drak, "द्राक्ष", "द्राक्ष"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.popay, "पोपाय", "पोपाय"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.panas, "पणस", "पणस"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.icon3, "भाजी", "भाजी"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.beet, "बीट", "बीट"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.vaig, "वायंगे", "वायंगे"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.kobi, "कोबी", "कोबी"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.gajar, "गाजर", "गाजर"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.full, "फुलकोबी", "फुलकोबी"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.mirchi, "मीरसांग", "मीरसांग"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.kotmir, "कोथमीर", "कोथमीर"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.karp, "करपील", "करपील"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.kano, "कांदो", "कांदो"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.batat, "बटाट", "बटाट"));
        } else if (i2 == 8) {
            learningDataModelArrayList = new ArrayList();
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.january, "January", "January"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.february, "February", "February"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.march, "March", "March"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.april, "April", "April"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.may, "May", "May"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.june, "June", "June"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.july, "July", "July"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.august, "August", "August"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.september, "September", "September"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.october, "October", "October"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.november, "November", "November"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.december, "December", "December"));
        } else if (i2 == 9) {
            learningDataModelArrayList = new ArrayList();
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.asparagus, "Asparagus", "Asparagus"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.broccoli, "Broccoli", "Broccoli"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.brussels_sprouts, "Brussels Sprouts", "Brussels Sprouts"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.carrot, "Carrot", "Carrot"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.cauliflower, "Cauliflower", "Cauliflower"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.cucumber, "Cucumber", "Cucumber"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.eggplant, "Eggplant", "Eggplant"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.garlic, "Garlic", "Garlic"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.lettuce, "Lettuce", "Lettuce"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.mint, "Mint", "Mint"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.mushroom, "Mushroom", "Mushroom"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.okra, "Okra", "Okra"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.onion, "Onion", "Onion"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.peaspeas, "Peaspeas", "Peaspeas"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.potato, "Potato", "Potato"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.radish, "Radish", "Radish"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.red_cabbage, "Red Cabbage", "Red Cabbage"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.spinach, "Spinach", "Spinach"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.squash, "Squash", "Squash"));
            //learningDataModelArrayList.add(new LearningDataModel(R.drawable.string_beans, "String Beans", "String Beans"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.tomato, "Tomato", "Tomato"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.turnip, "Turnip", "Turnip"));
        } else if (i2 == 10) {
            learningDataModelArrayList = new ArrayList();
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.ankle, "Ankle", "Ankle"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.arm, "Arm", "Arm"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.chest, "Chest", "Chest"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.ear, "Ear", "Ear"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.elbow, "Elbow", "Elbow"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.eye, "Eye", "Eye"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.fingers, "Fingers", "Fingers"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.foot, "Foot", "Foot"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.hair, "Hair", "Hair"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.knee, "Knee", "Knee"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.leg, "Leg", "Leg"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.lips1, "Lips", "Lips"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.mouth, "Mouth", "Mouth"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.neck, "Neck", "Neck"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.nose, "Nose", "Nose"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.shoulder, "Shoulder", "Shoulder"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.stomach, "Stomach", "Stomach"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.thigh, "Thigh", "Thigh"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.thumb, "Thumb", "Thumb"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.toe, "Toe", "Toe"));
        } else if (i2 == 3) {
            learningDataModelArrayList = new ArrayList();
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.au, "अ", "अ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.aah2, "आ", "आ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.aah3, "इ", " इ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.aah4, "ई", "ई"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.aah5, "उ", "उ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.aah6, "ऊ", "ऊ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.aah7, "ए", "ए "));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.aah8, "ऐ", "ऐ "));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.aah9, "ओ", "ओ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.aah10, "औ", "औ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.aah11, "um", "अंं"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.aah12, "अः", "अः"));



        } else if (i2 == 4) {
            learningDataModelArrayList = new ArrayList();
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.ka, "क", "क"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.kha, "ख", "ख"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.ga, "ग", "ग"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.gha, "घ", "घ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.nga, "ण", "ङ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.ca, "च", "च"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.cha, "छ", "छ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.ja, "ज", "ज"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.jha, "झ", "झ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.nja, "ञ", "ञ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.ta, "ट", "ट"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.th, "ठ", "ठ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.da, "ड", "ड"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.dh, "ढ", "ढ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.na, "ण", "ण"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.taa, "त", "त"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.thaa, "थ", "थ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.daa, "द", "द"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.dhaa, "ध", "ध"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.naa, "न", "न"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.pa, "प", "प"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.pha, "फ", "फ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.ba, "ब", "ब"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.bha,"भ", "भ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.ma, "म", "म"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.ya, "य", "य"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.ra, "र", "र"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.la, "ल", "ल"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.va, "व", "व"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.sa, "श", "श"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.ssa, "ष", "ष"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.sssa, "स", "स"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.ha, "ह", "ह"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.lha, "ळ", "ळ"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.ksa, "क्ष", "क्ष"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.jna, "ज्", "ज्ञ"));


        }  else {
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newa11, "A for Apple", "Apple"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newb, "B for Ball", "Ball"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newc, "C for Cat", "Cat"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newd, "D for Dog", "Dog"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newe, "E for Elephant", "Elephant"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newf, "F for Fish", "Fish"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newg, "G for Goat", "Goat"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newh1, "H for Horse", "Horse"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newi, "I for Ice cream", "Ice cream"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newj, "J for Joker", "Joker"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newk, "K for Kite", "Kite"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newl, "L for Lion", "Lion"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newm, "M for Monkey", "Monkey"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newn, "N for Nest", "Nest"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newo, "O for Orange", "Orange"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newp, "P for Parrot", "Parrot"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newq, "Q for Queen", "Queen"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newr, "R for Rabbit", "Rabbit"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.news, "S for Sun", "Sun"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newt, "T for Train", "Train"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newu, "U for Umbrella", "Umbrella"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newv, "V for Violin", "Violin"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.neww, "W for Watch", "Watch"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newx, "X for Xylophone", "Xylophone"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newy2, "Y for Yak", "Yak"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.newz, "Z for Zebra", "Zebra"));
        }
    }


}
