/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fclarke.gamifygold

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.fclarke.gamifygold.databinding.FragmentMainBinding
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference

//data class Card(val name: String, val id: Int, val  map:HashMap<String, Any>)
class MainFragment : Fragment() {

    companion object {
        const val TAG = "MainFragment"
        const val SIGN_IN_RESULT_CODE = 1001
    }

    val cardsArr = ArrayList<Int>()
    //val cardsArr: ArrayList<Int> = arrayListOf()


    private val cards: Cards = Cards()
    val thePlayer =
        Player(Enemy.HERO.theName, Enemy.HERO.ordinal, Enemy.DEMON.theName, 3, 0, 0, cardsArr)


    // Get a reference to the ViewModel scoped to this Fragment
    private val viewModel by viewModels<LoginViewModel>()
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        cardsArr.add(0)
        // TODO Remove the two lines below once observeAuthenticationState is implemented.
        binding.welcomeText.text = viewModel.getFactToDisplay(requireContext())
        binding.authButton.text = getString(R.string.login_btn)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeAuthenticationState()
        binding.authButton.setOnClickListener { launchSignInFlow() } //Login button

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //a new user signed up via email address
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SIGN_IN_RESULT_CODE) {
            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == Activity.RESULT_OK) {
                // User successfully signed in
                val email: String = response?.email.toString()
                Log.i(//this works
                    TAG,
                    "Successfully signed in user ${FirebaseAuth.getInstance().currentUser?.displayName}!"
                )

                //addCards()
                FirebaseUtils().db.collection("cards")
                    .get()
                    .addOnSuccessListener { querySnapshot ->
                        querySnapshot.forEach { document ->
                            Log.d(TAG, "Read document with ID ${document.id} ${document["name"]}")
                            //deleteAll("cards")
                            val value: HashMap<*, *>? =
                                document.data["value"] as? HashMap<*, *>//?as is nullable, so no crashing if null
                            val ref = value?.get("ref")//foreign key
                            val docRef: DocumentReference? = ref as? DocumentReference
                            docRef?.get()?.addOnSuccessListener { querySnapshot ->//if not null
                                val dat: HashMap<*, *>? = querySnapshot.data as? HashMap<*, *>
                                val dv: HashMap<*, *>? = dat?.get("value") as? HashMap<*, *>
                                var name = dv?.get("name")
                                var xxex = 0
                            }?.addOnFailureListener { exception ->
                                Log.w(TAG, "Error getting documents $exception")
                            }
                        }
                    }
                    .addOnFailureListener { exception ->
                        Log.w(TAG, "Error getting documents $exception")
                    }


            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                Log.i(TAG, "Sign in unsuccessful ${response?.error?.errorCode}")
            }
        }
    }

    private fun dealHand(player: Player) {
        var al = ArrayList<Int>()
        al.add(Cards.CARDS.FIGHTING_WORDS.ordinal)
        al.add(Cards.CARDS.DIVINE_INSPIRATION.ordinal)
        al.add(Cards.CARDS.CURE_WOUNDS.ordinal)
        al.add(Cards.CARDS.HIGH_CHARISMA.ordinal)
        player.cards = al

        FirebaseUtils().db.collection("player").document(player.name)
            .set(player.getMap())
            .addOnSuccessListener {
                Log.d(TAG, "Added document with ID demon")
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error adding document $exception")
            }
    }


    private fun addCards() {
        for (item in cards.cardMap)
            addHash("cards", item)
    }

    private fun deleteAll(collectionPath: String) {
        FirebaseUtils().db.collection(collectionPath)
            .get()
            .addOnSuccessListener { querySnapshot ->
                querySnapshot.forEach { document ->
                    Log.d(TAG, "Read document with ID ${document.id}")
                    deleteCard("cards", document.id)
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents $exception")
            }
    }


    private fun addHash(
        collectionPath: String,
        hashMap: MutableMap.MutableEntry<Int, HashMap<String, Any>>
    ) {

        FirebaseUtils().db.collection(collectionPath)
            .document(hashMap.key.toString())
            .set(hashMap)
            .addOnSuccessListener {
                // Log.d(TAG, "Added document with ID ${name}")
                //deleteCard("cards", name)
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error adding document $exception")
            }
    }

    private fun deleteCard(collection: String, document: String) {
        FirebaseUtils().db.collection(collection).document(document)
            .delete()
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully deleted!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error deleting document", e) }
    }

    private fun readData(table: String) {
        FirebaseUtils().db.collection(table)
            .get()
            .addOnSuccessListener { querySnapshot ->
                querySnapshot.forEach { document ->
                    Log.d(TAG, "Read document with ID ${document.id}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents $exception")
            }

    }

    /**
     * Observes the authentication state and changes the UI accordingly.
     * If there is a logged in user: (1) show a logout button and (2) display their name.
     * If there is no logged in user: show a login button
     */
    private fun observeAuthenticationState() {
        val factToDisplay = viewModel.getFactToDisplay(requireContext())

        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                LoginViewModel.AuthenticationState.AUTHENTICATED -> {
                    binding.welcomeText.text = getFactWithPersonalization(factToDisplay)
                    binding.authButton.text = getString(R.string.logout_button_text)
                    binding.authButton.setOnClickListener {
                        AuthUI.getInstance().signOut(requireContext())
                    }

                    dealHand(thePlayer)
                }
                else -> {
                    binding.welcomeText.text = factToDisplay

                    binding.authButton.text = getString(R.string.login_button_text)
                    binding.authButton.setOnClickListener {
                        launchSignInFlow()
                    }
                }
            }
        })
    }


    private fun getFactWithPersonalization(fact: String): String {
        return String.format(
            resources.getString(
                R.string.welcome_message_authed,
                FirebaseAuth.getInstance().currentUser?.displayName,
                Character.toLowerCase(fact[0]) + fact.substring(1)
            )
        )
    }

    private fun launchSignInFlow() { //click Login button
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(), AuthUI.IdpConfig.GoogleBuilder().build()
            //
        )

        // Create and launch sign-in intent.
        //continue with gmail
        startActivityForResult(
            AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(
                providers
            ).build(), MainFragment.SIGN_IN_RESULT_CODE
        )
    }
}