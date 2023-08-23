import {Component, OnInit} from '@angular/core';
import {Client} from "../../models/client";
import {ClientService} from "../../services/client/client.service";

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  clients: Array<Client> = []

  constructor(private clientService: ClientService) {
  }

ngOnInit(): void {
        this.clientService
          .getClients()
          .subscribe(clientsFromServer => {
            console.log("Data from server" + JSON.stringify(clientsFromServer, null, 2))
            this.clients = clientsFromServer
          })
    }

}
