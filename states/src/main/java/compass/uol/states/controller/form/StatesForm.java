package compass.uol.states.controller.form;

import com.sun.istack.NotNull;
import compass.uol.states.controller.dto.StatesDto;
import compass.uol.states.model.RegionEnum;
import compass.uol.states.model.States;
import compass.uol.states.repository.StatesRepository;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

public class StatesForm {

    @NotNull @NotEmpty
    private String name;
    @Enumerated(EnumType.STRING)
    private RegionEnum region;
    private Long population;
    private String capital;
    private double area;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RegionEnum getRegion() {
        return region;
    }

    public void setRegion(RegionEnum region) {
        this.region = region;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public States update(Long id, StatesRepository statesRepository) {
        States state = (States) statesRepository.getById(id);
        state.setName(this.name);
        state.setPopulation(this.population);
        state.setCapital(this.capital);
        state.setArea(this.area);
        
        return state;
    }

    public States getStates(StatesForm statesForm) {
        return new States(getName(),getRegion(),getPopulation(),getCapital(),getArea());
    }
}


