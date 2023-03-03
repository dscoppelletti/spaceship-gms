/*
 * Copyright (C) 2021 Dario Scoppelletti, <http://www.scoppelletti.it/>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.scoppelletti.spaceship.gms.auth

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.tasks.Task

/**
 * Contract for authentication Using Google Sign-In
 *
 * * [Authenticate Using Google Sign-In on Android](http://firebase.google.com/docs/auth/android/google-signin)
 * * [Getting a result from an activity](http://developer.android.com/training/basics/intents/result)
 *
 * @since 1.0.0
 */
public class GoogleSignInContract : ActivityResultContract<GoogleSignInClient,
        Task<GoogleSignInAccount>>() {

    override fun createIntent(
            context: Context,
            input: GoogleSignInClient
    ): Intent = input.signInIntent

    override fun parseResult(
            resultCode: Int,
            intent: Intent?
    ): Task<GoogleSignInAccount> =
            GoogleSignIn.getSignedInAccountFromIntent(intent)
}
