import { HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable, Output } from '@angular/core';
import { LocalStorageService } from 'angular-web-storage';
import { map } from 'rxjs/operators';
import { Activity } from '../models/activity';
import { ActivityDetails } from '../models/activityDetails';
import { Reservation } from '../models/reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  reservationInfo: Reservation;

  @Output() reservationSelected: EventEmitter<Reservation> = new EventEmitter();

  constructor(private http: HttpClient, private storage: LocalStorageService) { }

  onReservationSelected(reservation: Reservation) {
    this.reservationSelected.emit(reservation);
    this.reservationInfo = reservation;
  }

  createReservation() {
    let activity = this.createNewActivity();
    // let user = getLogedUser();
    const headers = {
      'Content-type': 'application/json'
    };
    let body = JSON.stringify(activity);
    this.createReservationDetails(activity);
    return this.http.post('http://localhost:8081/activity/addActivity', body, { headers }
    ).pipe(map((res: Response) => {
    }));
  }

  createReservationDetails(activity: Activity) {
    let activityDetails = new ActivityDetails();
    activityDetails.beginDate = this.reservationInfo.startDate;
    activityDetails.endDate = this.reservationInfo.endDate;
    activityDetails.activityId = activity.id;

    const headers = {
      'Content-type': 'application/json'
    };
    let body = JSON.stringify(activityDetails);
    return this.http.post('http://localhost:8081/activityDetails/addDetail', body, { headers }
    ).pipe(map((res: Response) => {
    }));
  }

  createNewActivity() {
    let activity = new Activity();
    activity.carId = this.reservationInfo.car.id;
    activity.isRental = this.reservationInfo.isRental;
    activity.isReservation = !activity.isRental;
    return activity;
  }
}
