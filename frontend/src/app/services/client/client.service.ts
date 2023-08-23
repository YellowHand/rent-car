import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {allClientsUrl} from "../../models/urls";
import {Client} from "../../models/client";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private httpClient: HttpClient) { }
  getClients():Observable<Array<Client>> {
    return this.httpClient
      .get<Array<Client>>(allClientsUrl)
  }
}
