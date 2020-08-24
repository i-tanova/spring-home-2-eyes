package com.tanovait.home2eye;

import com.tanovait.home2eye.model.City;
import com.tanovait.home2eye.model.Neighbourhood;
import com.tanovait.home2eye.model.Property;
import com.tanovait.home2eye.model.PropertyType;
import com.tanovait.home2eye.repository.CityRepository;
import com.tanovait.home2eye.repository.NeighbourhoodRepository;
import com.tanovait.home2eye.repository.PropertyRepository;
import com.tanovait.home2eye.repository.PropertyTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Home2eyeApplicationInit implements CommandLineRunner {

    private PropertyRepository propertyRepository;
    private PropertyTypeRepository propertyTypeRepository;
    private NeighbourhoodRepository neighbourhoodRepository;
    private CityRepository cityRepository;

    public Home2eyeApplicationInit(PropertyRepository propertyRepository, PropertyTypeRepository propertyTypeRepository, NeighbourhoodRepository neighbourhoodRepository, CityRepository cityRepository){
        this.propertyRepository = propertyRepository;
        this.propertyTypeRepository = propertyTypeRepository;
        this.neighbourhoodRepository = neighbourhoodRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
       initProperty();
    }

    private void initProperty() {
        City city = new City();
        city.setName("Sofia");

        Neighbourhood neighbourhood = new Neighbourhood();
        neighbourhood.setName("Lulin");
        city.addNeighbourhood(neighbourhood);
        City savedCity = cityRepository.save(city);

        Property property = new Property();
        property.setCity(savedCity);

        PropertyType propertyType = propertyTypeRepository.findByName("apartment").get();
        property.setPropertyType(propertyType);

        propertyRepository.save(property);
    }
}
