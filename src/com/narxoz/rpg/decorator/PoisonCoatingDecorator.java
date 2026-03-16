package com.narxoz.rpg.decorator;

public class PoisonCoatingDecorator extends ActionDecorator {
    public PoisonCoatingDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return super.getActionName() + " (Venomous)";
    }

    @Override
    public int getDamage() {
        return super.getDamage() + 10;
    }

    @Override
    public String getEffectSummary() {
        // TODO: Append or compose the poison effect description.
        return super.getEffectSummary() + ", applies deadly toxins";
    }
}
