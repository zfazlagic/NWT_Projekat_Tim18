import { Component, OnInit, ViewChild } from '@angular/core';
import { TabsetComponent } from 'ngx-bootstrap';
import { Car } from '../models/car';
import { Reservation } from '../models/reservation';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  @ViewChild('staticTabs') staticTabs: TabsetComponent;

  reservationInfo: Reservation;

  selectTab(tabId: number) {
    this.staticTabs.tabs[tabId].active = true;
  }

  constructor() { }

  ngOnInit() {
    
  }

}
