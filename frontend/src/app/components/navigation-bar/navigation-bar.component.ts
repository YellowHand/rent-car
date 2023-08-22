import { Component } from '@angular/core';
import {aboutUrl, carsUrl, clientsUrl, homePageUrl, rentsHistoryUrl} from "../../models/urls";

@Component({
  selector: 'app-navigation-bar',
  templateUrl: './navigation-bar.component.html',
  styleUrls: ['./navigation-bar.component.css']
})
export class NavigationBarComponent {

  protected readonly homePageUrl = homePageUrl;
  protected readonly rentsHistoryUrl = rentsHistoryUrl;
  protected readonly carsUrl = carsUrl;
  protected readonly clientsUrl = clientsUrl;
  protected readonly aboutUrl = aboutUrl;
}
