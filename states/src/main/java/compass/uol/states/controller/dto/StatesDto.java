package compass.uol.states.controller.dto;

import compass.uol.states.model.RegionEnum;
import compass.uol.states.model.States;

import java.util.List;
import java.util.stream.Collectors;

public class StatesDto {
    private Long id;
    private String name;
    private RegionEnum region;
    private Long population;
    private String capital;
    private double area;

    public StatesDto() {

    }

    public StatesDto(States state) {
        this.id = state.getId();
        this.name = state.getName();
        this.region = state.getRegion();
        this.population = state.getPopulation();
        this.capital = state.getCapital();
        this.area = state.getArea();
    }

    public static List<StatesDto> convert(List<States> states) {
        return states.stream().map(StatesDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public RegionEnum getRegion() {
        return region;
    }

    public Long getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }

    public double getArea() {
        return area;
    }
}
