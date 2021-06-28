package model;

import lombok.*;

import static Util.Utility.clamp;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ArenaTableComponent {

    private int arenas;

    private int amountOctopi;
    private double preferredBetAmount;
    private int experience;
    private TimeZones timeZone;

    private double[] values;

    public ArenaTableComponent(int amountOctopi, double preferredBetAmount, int experience, TimeZones timeZone) {
    this.amountOctopi = amountOctopi;
    this.preferredBetAmount = preferredBetAmount;
    this.experience = experience;
    this.timeZone = timeZone;
}

private void setValues(int arenas, int amountOctopi, double preferredBetAmount, int experience, TimeZones timeZone) {
        this.arenas = arenas;
        this.amountOctopi = amountOctopi;
        this.preferredBetAmount = preferredBetAmount;
        this.experience = experience;
        this.timeZone = timeZone;
    }

    private void setValues(int amountOctopi, double preferredBetAmount, int experience, TimeZones timeZone) {
        this.amountOctopi = amountOctopi;
        this.preferredBetAmount = preferredBetAmount;
        this.experience = experience;
        this.timeZone = timeZone;
    }

    public void setValues(double[] v, int amountOfArenas) {

        int position = (int) clamp(v[3], 0, TimeZones.values().length);
        setValues( (int) (amountOfArenas*10 / v[0]), (int) v[0], v[1], (int) v[2], TimeZones.values()[position]);

    }

    public void setValues(double[] v) {

        int position = (int) clamp(v[3], 0, TimeZones.values().length);
        setValues( (int) v[0], v[1], (int) v[2], TimeZones.values()[position]);

    }

    public double[] getValues () {
        return new double[] {amountOctopi, preferredBetAmount, experience,  timeZone.getTimezoneNumber()};
    }

}
