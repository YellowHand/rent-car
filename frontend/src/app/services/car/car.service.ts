import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {allCarsUrl} from "../../models/urls";
import {Car} from "../../models/car.";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private httpClient: HttpClient) { }
  getCars():Observable<Array<Car>> {
    return this.httpClient
      .get<Array<Car>>(allCarsUrl)
  }
}
