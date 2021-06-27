package model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ArenaTableComponent {
    private int arenas;
    private double preferredBetAmount;
    private int amountOctopi;
    private int experience;
    private TimeZones timeZone;
    private double norm;

    public ArenaTableComponent(int arenas, double preferredBetAmount, int amountOctopi, int experience, TimeZones timezone) {
        this.arenas = arenas;
        this.preferredBetAmount = preferredBetAmount;
        this.amountOctopi = amountOctopi;
        this.experience = experience;
        this.timeZone = timezone;
        calculateNorm();
    }

    public ArenaTableComponent(double preferredBetAmount, int amountOctopi, int experience, TimeZones timezone) {
        this.preferredBetAmount = preferredBetAmount;
        this.amountOctopi = amountOctopi;
        this.experience = experience;
        this.timeZone = timezone;
        calculateNorm();
    }

    private void calculateNorm(){
        double n = 0;
        n += preferredBetAmount * preferredBetAmount;
        n += amountOctopi * amountOctopi;
        n += experience * experience;
        n += timeZone.getTimezoneNumber() * timeZone.getTimezoneNumber();
        norm = Math.sqrt(n);
    }

    public double calculateQuotient(ArenaTableComponent tableComponent){
        double quotient = 0;
        quotient += preferredBetAmount * tableComponent.getPreferredBetAmount();
        quotient += amountOctopi * tableComponent.getAmountOctopi();
        quotient += experience * tableComponent.getExperience();
        quotient += timeZone.getTimezoneNumber() * tableComponent.getTimeZone().getTimezoneNumber();
        return quotient;
    }
}
