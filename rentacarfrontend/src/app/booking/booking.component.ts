import { Component, OnInit, ViewChild } from '@angular/core';
import { TabsetComponent } from 'ngx-bootstrap';
import { Reservation } from '../models/reservation';
import { ReservationService } from '../shared/reservation.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  @ViewChild('staticTabs') staticTabs: TabsetComponent;

  reservationInfo: Reservation;
  reservationExists = false;

  constructor(private reservationService: ReservationService) { }

  ngOnInit() {
    this.reservationInfo = new Reservation();
    this.reservationInfo.id = 0;
    this.reservationService.currentReservation.subscribe(reservationInfo => this.updateScreen(reservationInfo));
  }

  updateScreen(reservationInfo: Reservation) {
    if (typeof reservationInfo === 'undefined' || reservationInfo == null) {
      this.reservationExists = false;
    }
    this.reservationExists = true;
    this.reservationInfo = reservationInfo;
  }

  selectTab(tabId: number) {
    this.staticTabs.tabs[tabId].active = true;
  }

}
