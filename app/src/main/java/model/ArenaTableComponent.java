package model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ArenaTableComponent {
    private int arenas;
    private double minimumBet;
    private double maximumBet;
    private int amountOctopi;
    private int experience;
    private TimeZones timeZone;
    private double norm;

    public ArenaTableComponent(int arenas, double minimumBet, double maximumBet, int amountOctopi, int experience, TimeZones timezone) {
        this.arenas = arenas;
        this.minimumBet = minimumBet;
        this.maximumBet = maximumBet;
        this.amountOctopi = amountOctopi;
        this.experience = experience;
        this.timeZone = timezone;
        calculateNorm();
    }

    public ArenaTableComponent(double minimumBet, double maximumBet, int amountOctopi, int experience, TimeZones timezone) {
        this.minimumBet = minimumBet;
        this.maximumBet = maximumBet;
        this.amountOctopi = amountOctopi;
        this.experience = experience;
        this.timeZone = timezone;
        calculateNorm();
    }

    private void calculateNorm(){
        double n = 0;
        n += minimumBet * minimumBet;
        n += maximumBet * maximumBet;
        n += amountOctopi * amountOctopi;
        n += experience * experience;
        n += timeZone.getTimezoneNumber() * timeZone.getTimezoneNumber();
        norm = Math.sqrt(n);
    }

    public double calculateQuotient(ArenaTableComponent tableComponent){
        double quotient = 0;
        quotient += minimumBet * tableComponent.getMinimumBet();
        quotient += maximumBet * tableComponent.getMaximumBet();
        quotient += amountOctopi * tableComponent.getAmountOctopi();
        quotient += experience * tableComponent.getExperience();
        quotient += timeZone.getTimezoneNumber() * tableComponent.getTimeZone().getTimezoneNumber();
        return quotient;
    }
}
