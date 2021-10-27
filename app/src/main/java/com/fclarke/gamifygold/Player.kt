package com.fclarke.gamifygold

enum class Enemy(val theName: String) {
    HERO("hero"),
    DEMON("demon")
    /*
    val en= Enemy.DEMON.name "DEMON"
    val en2= Enemy.DEMON.theName "demon"
    Enemy.HERO.ordinal  0
    */
}

class Player() {
    constructor(
        _name: String,
        _theClass: Int,
        _enemy: String,
        _gold: Int,
        _mana: Int,
        _shields: Int,
        _cards: ArrayList<Int>
    ) : this() {
        name = _name
        theClass = _theClass
        enemy = _enemy
        gold = _gold
        mana = _mana
        shields = _shields
        cards = _cards
    }

    fun getMap(): HashMap<String, Any> {
        val map: HashMap<String, Any> =
            hashMapOf("name" to name, "class" to theClass,"enemy" to enemy, "gold" to gold,"mana" to mana , "shields" to shields, "cards" to cards)
        return map
    }


    var theClass: Int = 0
    var gold: Int = 0
    var shields: Int = 0
    var mana: Int = 0
    lateinit var enemy: String
    lateinit var name: String
    lateinit var cards: ArrayList<Int>

    enum class CLASSES {
        BARBARIAN,
        PALADIN,
        ROGUE,
        WIZARD,
        BEHOLDER,
        MIND_FLAYER,
        GELATINOUS_CUBE,
        MIMIC,
        RED_DRAGON,
        OWLBEAR
    }
}