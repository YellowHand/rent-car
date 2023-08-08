import { Component } from '@angular/core';
import {CarService} from "../../services/car/car.service";

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent {

  constructor(private carService: CarService) {

  }

}
