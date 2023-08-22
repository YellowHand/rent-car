import { Component } from '@angular/core';
import {homePageUrl} from "../../models/urls";

@Component({
  selector: 'app-not-found',
  templateUrl: './not-found.component.html',
  styleUrls: ['./not-found.component.css']
})
export class NotFoundComponent {

  protected readonly homePageUrl = homePageUrl;
}
