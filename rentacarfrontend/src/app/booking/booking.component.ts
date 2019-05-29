import { Component, OnInit, ViewChild } from '@angular/core';
import { TabsetComponent } from 'ngx-bootstrap';
import { Reservation } from '../models/reservation';
import { ReservationService } from '../shared/reservation.service';
import { Car } from '../models/car';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  @ViewChild('staticTabs') staticTabs: TabsetComponent;

  reservationInfo: Reservation;
  reservationExists = false;

  constructor(private reservationService: ReservationService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.reservationInfo = this.reservationService.reservationInfo;
    this.validateBooking(this.reservationInfo);
  }

  validateBooking(reservation: Reservation) {
    if (typeof reservation === 'undefined') {
      this.reservationExists = false;
      return;
    }
    this.reservationExists = true;
  }

  selectTab(tabId: number) {
    this.staticTabs.tabs[tabId].active = true;
  }

}
