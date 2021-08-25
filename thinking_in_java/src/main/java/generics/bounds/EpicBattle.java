package generics.bounds;// generics/EpicBattle.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Bounds in Java generics

import java.util.*;

interface SuperPower {
}

interface XRayVision extends SuperPower {
    void seeThroughWalls();
}

interface SuperHearing extends SuperPower {
    // 听到细微的噪音
    void hearSubtleNoises();
}

interface SuperSmell extends SuperPower {
    // 按气味追踪
    void trackBySmell();
}

class SuperHero<POWER extends SuperPower> {
    POWER power;

    SuperHero(POWER power) {
        this.power = power;
    }

    POWER getPower() {
        return power;
    }
}

// 超级侦探
class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER> {

    SuperSleuth(POWER power) {
        super(power);
    }

    void see() {
        power.seeThroughWalls();
    }
}

// 犬类英雄
class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER> {

    CanineHero(POWER power) {
        super(power);
    }

    void hear() {
        power.hearSubtleNoises();
    }

    void smell() {
        power.trackBySmell();
    }
}

// 超级听力、嗅觉
class SuperHearSmell implements SuperHearing, SuperSmell {
    @Override
    public void hearSubtleNoises() {
    }

    @Override
    public void trackBySmell() {
    }
}

// 狗人
class DogPerson extends CanineHero<SuperHearSmell> {
    DogPerson() {
        super(new SuperHearSmell());
    }
}

public class EpicBattle {

    // Bounds in generic methods:
    static <POWER extends SuperHearing>
    void useSuperHearing(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoises();
    }

    static <POWE extends SuperHearing & SuperSmell>
    void superFind(SuperHero<POWE> hero) {
        hero.getPower().hearSubtleNoises();
        hero.getPower().trackBySmell();
    }

    public static void main(String[] args) {
        DogPerson dogPerson = new DogPerson();
        useSuperHearing(dogPerson);
        superFind(dogPerson);

        // You can do this:
        List<? extends SuperHearing> audioPeople;
        // But you can't do this:
        // List<? extends SuperHearing & SuperSmell> dogPs;
    }
}
