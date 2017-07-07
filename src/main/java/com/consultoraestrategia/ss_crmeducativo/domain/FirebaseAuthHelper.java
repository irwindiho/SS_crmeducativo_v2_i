package com.consultoraestrategia.ss_crmeducativo.domain;


import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by kelvi on 21/02/2017.
 */

public class FirebaseAuthHelper {
  private FirebaseAuth mAuth;

  private static class SingletonFirebaseAuthHelper {
    private static final FirebaseAuthHelper INSTANCE = new FirebaseAuthHelper();
  }

  public static FirebaseAuthHelper getInstace() {
    return SingletonFirebaseAuthHelper.INSTANCE;
  }

  public FirebaseAuthHelper() {
    mAuth = FirebaseAuth.getInstance();
  }

  public FirebaseAuth getmAuth() {
    return mAuth;
  }

}
