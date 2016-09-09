package com.example.ashish.speakingtree_android.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 8/26/2016.
 */
public class MasterModel {

       private String count;
        private List<MasterUser> user = new ArrayList<MasterUser>();
        /**
         *
         * @return
         * The count
         */
        public String getCount() {
            return count;
        }

        /**
         *
         * @param count
         * The count
         */
        public void setCount(String count) {
            this.count = count;
        }

        /**
         *
         * @return
         * The user
         */
        public List<MasterUser> getUser() {
            return user;
        }

        /**
         *
         * @param user
         * The user
         */
        public void setUser(List<MasterUser> user) {
            this.user = user;
        }

}
