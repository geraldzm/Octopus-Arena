package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArenaInformation {
    private Integer arenaNumber;
    private Double fee;
    private Integer octopusAmount;
    private String startTime;
    private Boolean isStarted;
    private Double minBet;
    private Double maxBet;
}
