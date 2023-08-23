import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {ClientService} from "../../services/client/client.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {Client} from "../../models/client";


@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit, AfterViewInit {
  displayedColumns: string[] = ['id', 'name', 'surname', 'pesel', 'email', 'dateOfBirth',
    'phone', 'addressDto', 'accountCreated'];
  clients: Array<Client> = [];
  dataSource: MatTableDataSource<Client> = new MatTableDataSource<Client>(this.clients);
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(
    private clientService: ClientService
  ) {
  }
  ngOnInit(): void {
    this.clientService.getClients()
      .subscribe(clients => {
        console.log(`Clients from server: ${JSON.stringify(clients, null, 2)}`)
        this.dataSource.data = clients;
      })
  }
  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}
