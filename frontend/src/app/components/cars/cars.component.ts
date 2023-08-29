import {Component, OnInit, ViewChild} from '@angular/core';
import {CarService} from "../../services/car/car.service";
import {Car} from "../../models/car.";
import {FormControl, FormGroup} from "@angular/forms";
import {MatButton} from "@angular/material/button";
import {delay} from "rxjs";

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  @ViewChild('submitbutton') submitButton!: MatButton
  cars: Array<Car> = []
  carForm = new FormGroup({
    model: new FormControl(''),
    brand: new FormControl(''),
    fuelType: new FormControl(''),
    engineType: new FormControl(''),
    bodyType: new FormControl(''),
    numberOfSeats: new FormControl(4),
    trunkCapacityInLitres: new FormControl(200),
    combustionPer100Km: new FormControl(''),
    bodySerialNumber: new FormControl(''),
    pricePerDayInPolishGrosz: new FormControl(0),
    available: new FormControl(true),
    rangeInKm: new FormControl(300),
    pictures: new FormGroup({
      mainPictureUrl: new FormControl(''),
      picturesUrls: new FormControl(new Array<string>())
    })
  })
  value: any;
  get model() {
    return this.carForm.controls.model
  }

  get brand() {
    return this.carForm.controls.brand;
  }

  get fuelType() {
    return this.carForm.controls.fuelType;
  }

  get engineType() {
    return this.carForm.controls.engineType;
  }

  get bodyType() {
    return this.carForm.controls.bodyType;
  }

  get numberOfSeats() {
    return this.carForm.controls.numberOfSeats;
  }

  get trunkCapacityInLitres() {
    return this.carForm.controls.trunkCapacityInLitres;
  }

  get combustionPer100Km() {
    return this.carForm.controls.combustionPer100Km;
  }

  get bodySerialNumber() {
    return this.carForm.controls.bodySerialNumber;
  }

  get pricePerDayInPolishGrosz() {
    return this.carForm.controls.pricePerDayInPolishGrosz;
  }

  get available() {
    return this.carForm.controls.available;
  }

  get rangeInKm() {
    return this.carForm.controls.rangeInKm;
  }

  get mainPictureUrl() {
    return this.carForm.controls.pictures.controls.mainPictureUrl;
  }

  get picturesUrls() {
    return this.carForm.controls.pictures.controls.picturesUrls;
  }


  constructor(private carService: CarService) {

  }

  ngOnInit(): void {
    this.getDataFromServer();
  }

  private getDataFromServer() {
    this.carService
      .getCars()
      .subscribe(carsFromServer => {
        console.log("Data from server" + JSON.stringify(carsFromServer, null, 2))
        this.cars = carsFromServer
      })
  }

  sendCar() {
    this.submitButton.disabled = true;
    console.log("data submitted")
    this.value = this.carForm.value
    this.carService.sendCar(this.carForm.value as Car)
      .pipe(delay(1000))
      .subscribe(response => {
        console.log("Car created")
        this.getDataFromServer();
        this.carForm.reset();
          this.submitButton.disabled = false;
      },
        error => {
        console.log("Error")
          this.submitButton.disabled = false;
        })
  }
}
