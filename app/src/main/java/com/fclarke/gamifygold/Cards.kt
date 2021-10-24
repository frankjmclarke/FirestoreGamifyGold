package com.fclarke.gamifygold

class Cards {
    val cardMap = hashMapOf<Int,HashMap<String, Any>>()
    enum class CARDS {
        DIVINE_SMITE,
        DIVINE_SHIELD,
        FIGHTING_WORDS,
        FINGER_WAG_OF_JUDGEMENT,
        FOR_JUSTICE,
        FOR_EVEN_MORE_JUSTICE,
        FOR_THE_MOST_JUSTICE,
        DIVINE_INSPIRATION,
        CURE_WOUNDS,
        SPINNING_PARRY,
        BANISHING_SMITE,
        HIGH_CHARISMA,
        FLUFFY
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
        "name" to "Divine Smite",
        "cardicon" to CARDS.DIVINE_SMITE.ordinal,
        "icon1" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon2" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon3" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon4" to ACTIONS.HEAL.ordinal,
        "cost" to 4
    )
    private val divineShield = hashMapOf<String, Any>(
        "name" to "Divine Shield",
        "cardicon" to CARDS.DIVINE_SHIELD.ordinal,
        "icon1" to ACTIONS.SHIELD.ordinal,
        "icon2" to ACTIONS.SHIELD.ordinal,
        "icon3" to ACTIONS.SHIELD.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 3
    )
    private val fightingWords = hashMapOf<String, Any>(
        "name" to "Fighting Words",
        "cardicon" to CARDS.FIGHTING_WORDS.ordinal,
        "icon1" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon2" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon3" to ACTIONS.HEAL.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 3
    )
    private val fingerWagOfJudgement = hashMapOf<String, Any>(
        "name" to "Finger Wag Of Judgement",
        "cardicon" to CARDS.FINGER_WAG_OF_JUDGEMENT.ordinal,
        "icon1" to ACTIONS.PLAY_EXTRA_CARD.ordinal,
        "icon2" to ACTIONS.PLAY_EXTRA_CARD.ordinal,
        "icon3" to ACTIONS.NONE.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 2
    )
    private val forJustice = hashMapOf<String, Any>(
        "name" to "For Justice!",
        "cardicon" to CARDS.FOR_JUSTICE.ordinal,
        "icon1" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon2" to ACTIONS.PLAY_EXTRA_CARD.ordinal,
        "icon3" to ACTIONS.NONE.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 2
    )
    private val forEvenMoreJustice = hashMapOf<String, Any>(
        "name" to "For even more Justice!",
        "cardicon" to CARDS.FOR_EVEN_MORE_JUSTICE.ordinal,
        "icon1" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon2" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon3" to ACTIONS.NONE.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 2
    )
    private val forTheMostJustice = hashMapOf<String, Any>(
        "name" to "For the most Justice!",
        "cardicon" to CARDS.FOR_THE_MOST_JUSTICE.ordinal,
        "icon1" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon2" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon3" to ACTIONS.DEAL_DAMAGE.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 3
    )
    private val divineInspiration = hashMapOf<String, Any>(
        "name" to "Divine Inspiration",
        "cardicon" to CARDS.DIVINE_INSPIRATION.ordinal,
        "icon1" to ACTIONS.SWAP_CARD.ordinal,
        "icon2" to ACTIONS.HEAL.ordinal,
        "icon3" to ACTIONS.HEAL.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 3
    )
    private val cureWounds = hashMapOf<String, Any>(
        "name" to "Cure Wounds",
        "cardicon" to CARDS.CURE_WOUNDS.ordinal,
        "icon1" to ACTIONS.DRAW_CARD.ordinal,
        "icon2" to ACTIONS.DRAW_CARD.ordinal,
        "icon3" to ACTIONS.HEAL.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 3
    )
    private val spinningParry = hashMapOf<String, Any>(
        "name" to "Spinning Parry",
        "cardicon" to CARDS.SPINNING_PARRY.ordinal,
        "icon1" to ACTIONS.SHIELD.ordinal,
        "icon2" to ACTIONS.DRAW_CARD.ordinal,
        "icon3" to ACTIONS.NONE.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 2
    )
    private val banishingSmite = hashMapOf<String, Any>(
        "name" to "Banishing Smite",
        "cardicon" to CARDS.BANISHING_SMITE.ordinal,
        "icon1" to ACTIONS.DESTROY_SHIELDS.ordinal,
        "icon2" to ACTIONS.PLAY_EXTRA_CARD.ordinal,
        "icon3" to ACTIONS.NONE.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 2
    )
    private val highCharisma = hashMapOf<String, Any>(
        "name" to "High Charisma",
        "cardicon" to CARDS.HIGH_CHARISMA.ordinal,
        "icon1" to ACTIONS.DRAW_CARD.ordinal,
        "icon2" to ACTIONS.DRAW_CARD.ordinal,
        "icon3" to ACTIONS.NONE.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 2
    )
    private val fluffy = hashMapOf<String, Any>(
        "name" to "Fluffy",
        "cardicon" to CARDS.FLUFFY.ordinal,
        "icon1" to ACTIONS.SHIELD.ordinal,
        "icon2" to ACTIONS.SHIELD.ordinal,
        "icon3" to ACTIONS.NONE.ordinal,
        "icon4" to ACTIONS.NONE.ordinal,
        "cost" to 2
    )
    public fun initCards() {
        var index :Int=0
        addHash(divineSmite,index++)
        addHash(divineShield,index++)
        addHash(fightingWords,index++)
        addHash(fingerWagOfJudgement,index++)
        addHash(forJustice,index++)
        addHash(forEvenMoreJustice,index++)
        addHash(forTheMostJustice,index++)
        addHash(divineInspiration,index++)
        addHash(cureWounds,index++)
        addHash(spinningParry,index++)
        addHash(banishingSmite,index++)
        addHash(highCharisma,index++)
        addHash(fluffy,index++)
    }

    private fun addHash(hashMap: HashMap<String, Any>, index: Int) {
        cardMap[index]=hashMap
    }
}