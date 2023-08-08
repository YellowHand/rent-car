import {Component, OnInit} from '@angular/core';
import {CarService} from "../../services/car/car.service";
import {Car} from "../../models/car.";

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  cars: Array<Car> = []
  constructor(private carService: CarService) {

  }

  ngOnInit(): void {
    this.carService
      .getCars()
      .subscribe(carsFromServer => {
        console.log("Data from server" + JSON.stringify(carsFromServer, null, 2))
        this.cars = carsFromServer
      })
  }

}
