import { Injectable, Output, EventEmitter } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Reservation } from '../models/reservation';
import { Car } from '../models/car';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  reservationInfo: Reservation;

  @Output() reservationSelected: EventEmitter<Reservation> = new EventEmitter();

  constructor() { }

  onReservationSelected(reservation: Reservation) {
    this.reservationSelected.emit(reservation);
    this.reservationInfo = reservation;
  }
}
