package com.prathmeshadsod.thehindustanprime.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.prathmeshadsod.thehindustanprime.Fragments.Archives;
import com.prathmeshadsod.thehindustanprime.Fragments.Business;
import com.prathmeshadsod.thehindustanprime.Fragments.Entertainment;
import com.prathmeshadsod.thehindustanprime.Fragments.Environment;
import com.prathmeshadsod.thehindustanprime.Fragments.Food;
import com.prathmeshadsod.thehindustanprime.Fragments.Health;
import com.prathmeshadsod.thehindustanprime.Fragments.Home;
import com.prathmeshadsod.thehindustanprime.Fragments.Politics;
import com.prathmeshadsod.thehindustanprime.Fragments.Science;
import com.prathmeshadsod.thehindustanprime.Fragments.Sports;
import com.prathmeshadsod.thehindustanprime.Fragments.Technology;
import com.prathmeshadsod.thehindustanprime.Fragments.Top;
import com.prathmeshadsod.thehindustanprime.Fragments.World;

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0 :
                return new Home();
            case 1 :
                return new Top();
            case 2 :
                return new World();
            case 3 :
                return new Health();
            case 4 :
                return new Entertainment();
            case 5 :
                return new Politics();
            case 6 :
                return new Environment();
            case 7 :
                return new Sports();
            case 8 :
                return new Science();
            case 9 :
                return new Technology();
            case 10 :
                return new Food();
            case 11 :
                return new Business();

            /* NewsData.io API is not giving access to us for there archives
       They wan't primium subscription for this that's why we created it but can't use it
     */
           /* case 12 :
                return new Archives(); */

            default:
                return new Home();


        }

    }

    @Override
    public int getCount() {
       // return 13;
        return 12;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;

        if(position == 0){
            title = "Home";
        }else if(position == 1){
            title = "Top";
        }
        else if(position == 2){
            title = "World";
        }else if(position == 3){
            title = "Health";
        }else if(position == 4){
            title = "Entertainment";
        }else if(position == 5){
            title = "Politics";
        }else if(position == 6){
            title = "Environment";
        }else if(position == 7){
            title = "Sports";
        }else if(position == 8){
            title = "Science";
        }else if(position == 9){
            title = "Technology";
        }else if(position == 10){
            title = "Food";
        }else if(position == 11){
            title = "Business";
        }

        /* NewsData.io API is not giving access to us for there archives
       They wan't primium subscription for this that's why we created it but can't use it
     */
      /*  else if(position == 12){
            title = "Archives";
        }*/

      return title;

    }
}
