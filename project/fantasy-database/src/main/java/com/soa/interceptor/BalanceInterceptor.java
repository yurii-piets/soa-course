package com.soa.interceptor;

import com.soa.domain.hero.Dragon;
import com.soa.domain.hero.Elf;
import com.soa.domain.hero.Hero;
import com.soa.domain.hero.Mag;
import com.soa.service.DataAccessService;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Balanced
@Interceptor
public class BalanceInterceptor {

    @EJB
    private DataAccessService dataService;

    @AroundInvoke
    public Object invoke(InvocationContext ctx) throws Exception {
        Object[] parameters = ctx.getParameters();
        if (parameters[0] instanceof Hero) {
            Hero currentHero = (Hero) parameters[0];
            balance(currentHero);
        }
        return ctx.proceed();
    }

    private void balance(Hero slave) {
        Hero strongest = null;
        if (slave instanceof Dragon) {
            Dragon reachest = dataService.findReachestDragon();
            balance(reachest, (Dragon) slave);
            strongest = dataService.findStrongestDragon();
        } else if (slave instanceof Elf) {
            Elf reachest = dataService.findReachestElf();
            balance(reachest, (Elf) slave);
            strongest = dataService.findStrongestElf();
        } else if (slave instanceof Mag) {
            Mag reachest = dataService.findReachestMag();
            balance(reachest, (Mag) slave);
            strongest = dataService.findStrongestMag();
        }

        if (strongest != null && strongest.getPower().getIntValue() < slave.getPower().getIntValue()) {
            slave.setPower(strongest.getPower());
        }
    }

    private void balance(Dragon master, Dragon slave) {
        if (master.getGold() < slave.getGold()) {
            slave.setGold(master.getGold());
        }
    }

    private void balance(Elf master, Elf slave) {
        if (master.getArrowCount() < slave.getArrowCount()) {
            slave.setArrowCount(master.getArrowCount());
        }
    }

    private void balance(Mag master, Mag slave) {
        if (master.getMana() < slave.getMana()) {
            slave.setMana(master.getMana());
        }
    }
}
