package ua.lviv.iot;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Drone extends AerialVehicle {
    private int batteryCapacityIn_mAh;
    private double chargeConsumingPerMinuteInPercentage;
    private int maxWeaponWeightInGrams;
    private int maxCargoWeightInGrams;
    private final int maxBatteryCapacityInPercentage = 100;

    public Drone(String manufacturer, int maxSpeed, EngineType engineType, int batteryCapacityIn_mAh,
                 double chargeConsumingPerMinuteInPercentage,
                 int maxWeaponWeightInGrams, int maxCargoWeightInGrams) {
        super(manufacturer, maxSpeed, engineType);
        this.batteryCapacityIn_mAh = batteryCapacityIn_mAh;
        this.chargeConsumingPerMinuteInPercentage = chargeConsumingPerMinuteInPercentage;
        this.maxWeaponWeightInGrams = maxWeaponWeightInGrams;
        this.maxCargoWeightInGrams = maxCargoWeightInGrams;
    }

    @Override
    public int getMaxFlyingDistance() {
        return (int) (maxSpeed * (maxBatteryCapacityInPercentage / chargeConsumingPerMinuteInPercentage));
    }

    @Override
    public int getMaxDeliveryWeight() {
        return maxCargoWeightInGrams + maxWeaponWeightInGrams;
    }

}