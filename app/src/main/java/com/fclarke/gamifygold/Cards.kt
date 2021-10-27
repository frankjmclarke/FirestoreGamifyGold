package com.fclarke.gamifygold

/*
Cards are constants within the game, no need to store in database
 */
class Cards {

    //val cardMap: HashMap<Int, HashMap<String, Any>> = hashMapOf()
    val cardMap = HashMap<Int, HashMap<String, Any>>()

    init {
        initCards()
    }


    enum class CARDS(val theName: String) {
        DIVINE_SMITE("Divine Smite"),
        DIVINE_SHIELD("Divine Shield"),
        FIGHTING_WORDS("Fighting Words"),
        FINGER_WAG_OF_JUDGEMENT("Finger Wag of Judgement"),
        FOR_JUSTICE("For Justice!"),
        FOR_EVEN_MORE_JUSTICE("For Even More Justice!"),
        FOR_THE_MOST_JUSTICE("For The Most Justice!"),
        DIVINE_INSPIRATION("Divine Inspiration"),
        CURE_WOUNDS("Cure Wounds"),
        SPINNING_PARRY("Spinning Parry"),
        BANISHING_SMITE("Banishing Smite"),
        HIGH_CHARISMA("High Charisma"),
        FLUFFY("Fluffy")
    }

    enum class ACTIONS {
        SHIELD,
        DRAW_CARD,
        DEAL_DAMAGE,
        PLAY_EXTRA_CARD,
        HEAL,
        SWAP_CARD,
        NONE,
        DESTROY_SHIELDS
    }

    private val divineSmite = hashMapOf<String, Any>(
        "name" to CARDS.DIVINE_SMITE.theName,
        "cardicon" to CARDS.DIVINE_SMITE.ordinal,
        "icon1" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon2" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon3" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon4" to ACTIONS.HEAL.ordinal,
        "cost" to 4
    )
    private val divineShield = hashMapOf<String, Any>(
        "name" to CARDS.DIVINE_SHIELD.theName,
        "cardicon" to CARDS.DIVINE_SHIELD.ordinal,
        "icon1" to ACTIONS.SHIELD.ordinal,
        "icon2" to ACTIONS.SHIELD.ordinal,
        "icon3" to ACTIONS.SHIELD.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 3
    )
    private val fightingWords = hashMapOf<String, Any>(
        "name" to CARDS.FIGHTING_WORDS.theName,
        "cardicon" to CARDS.FIGHTING_WORDS.ordinal,
        "icon1" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon2" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon3" to ACTIONS.HEAL.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 3
    )
    private val fingerWagOfJudgement = hashMapOf<String, Any>(
        "name" to CARDS.FINGER_WAG_OF_JUDGEMENT.theName,
        "cardicon" to CARDS.FINGER_WAG_OF_JUDGEMENT.ordinal,
        "icon1" to ACTIONS.PLAY_EXTRA_CARD.ordinal,
        "icon2" to ACTIONS.PLAY_EXTRA_CARD.ordinal,
        "icon3" to ACTIONS.NONE.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 2
    )
    private val forJustice = hashMapOf<String, Any>(
        "name" to CARDS.FOR_JUSTICE.theName,
        "cardicon" to CARDS.FOR_JUSTICE.ordinal,
        "icon1" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon2" to ACTIONS.PLAY_EXTRA_CARD.ordinal,
        "icon3" to ACTIONS.NONE.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 2
    )
    private val forEvenMoreJustice = hashMapOf<String, Any>(
        "name" to CARDS.FOR_EVEN_MORE_JUSTICE.theName,
        "cardicon" to CARDS.FOR_EVEN_MORE_JUSTICE.ordinal,
        "icon1" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon2" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon3" to ACTIONS.NONE.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 2
    )
    private val forTheMostJustice = hashMapOf<String, Any>(
        "name" to CARDS.FOR_THE_MOST_JUSTICE.theName,
        "cardicon" to CARDS.FOR_THE_MOST_JUSTICE.ordinal,
        "icon1" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon2" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon3" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 3
    )
    private val divineInspiration = hashMapOf<String, Any>(
        "name" to CARDS.DIVINE_INSPIRATION.theName,
        "cardicon" to CARDS.DIVINE_INSPIRATION.ordinal,
        "icon1" to ACTIONS.SWAP_CARD.ordinal,
        "icon2" to ACTIONS.HEAL.ordinal,
        "icon3" to ACTIONS.HEAL.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 3
    )
    private val cureWounds = hashMapOf<String, Any>(
        "name" to CARDS.CURE_WOUNDS.theName,
        "cardicon" to CARDS.CURE_WOUNDS.ordinal,
        "icon1" to ACTIONS.DRAW_CARD.ordinal,
        "icon2" to ACTIONS.DRAW_CARD.ordinal,
        "icon3" to ACTIONS.HEAL.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 3
    )
    private val spinningParry = hashMapOf<String, Any>(
        "name" to CARDS.SPINNING_PARRY.theName,
        "cardicon" to CARDS.SPINNING_PARRY.ordinal,
        "icon1" to ACTIONS.SHIELD.ordinal,
        "icon2" to ACTIONS.DRAW_CARD.ordinal,
        "icon3" to ACTIONS.NONE.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 2
    )
    private val banishingSmite = hashMapOf<String, Any>(
        "name" to CARDS.BANISHING_SMITE.theName,
        "cardicon" to CARDS.BANISHING_SMITE.ordinal,
        "icon1" to ACTIONS.DESTROY_SHIELDS.ordinal,
        "icon2" to ACTIONS.PLAY_EXTRA_CARD.ordinal,
        "icon3" to ACTIONS.NONE.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 2
    )
    private val highCharisma = hashMapOf<String, Any>(
        "name" to CARDS.HIGH_CHARISMA.theName,
        "cardicon" to CARDS.HIGH_CHARISMA.ordinal,
        "icon1" to ACTIONS.DRAW_CARD.ordinal,
        "icon2" to ACTIONS.DRAW_CARD.ordinal,
        "icon3" to ACTIONS.NONE.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 2
    )
    private val fluffy = hashMapOf<String, Any>(
        "name" to CARDS.FLUFFY.theName,
        "cardicon" to CARDS.FLUFFY.ordinal,
        "icon1" to ACTIONS.SHIELD.ordinal,
        "icon2" to ACTIONS.SHIELD.ordinal,
        "icon3" to ACTIONS.NONE.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 2
    )

    fun initCards() {
        addHash(divineSmite, CARDS.DIVINE_SMITE.ordinal)
        addHash(divineShield, CARDS.DIVINE_SMITE.ordinal)
        addHash(fightingWords, CARDS.FIGHTING_WORDS.ordinal)
        addHash(fingerWagOfJudgement, CARDS.DIVINE_SMITE.ordinal)
        addHash(forJustice, CARDS.FOR_JUSTICE.ordinal)
        addHash(forEvenMoreJustice, CARDS.FOR_EVEN_MORE_JUSTICE.ordinal)
        addHash(forTheMostJustice, CARDS.FOR_THE_MOST_JUSTICE.ordinal)
        addHash(divineInspiration, CARDS.DIVINE_INSPIRATION.ordinal)
        addHash(cureWounds, CARDS.CURE_WOUNDS.ordinal)
        addHash(spinningParry, CARDS.SPINNING_PARRY.ordinal)
        addHash(banishingSmite, CARDS.BANISHING_SMITE.ordinal)
        addHash(highCharisma, CARDS.HIGH_CHARISMA.ordinal)
        addHash(fluffy, CARDS.FLUFFY.ordinal)
    }

    private fun addHash(hashMap: HashMap<String, Any>, index: Int) {
        cardMap[index] = hashMap
    }
}