import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Reservation } from '../models/reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private reservationInfo = new BehaviorSubject(new Reservation());
  currentReservation = this.reservationInfo.asObservable();

  constructor() { }

  addReservation(reservationInfo: Reservation) {
    this.reservationInfo.next(reservationInfo);
  }
}
