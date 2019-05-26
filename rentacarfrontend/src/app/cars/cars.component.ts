import { Component, OnInit, TemplateRef } from '@angular/core';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { Car } from '../models/car';
import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  // Update to be array of type Car
  cars: Car[] = [];

  // Modal info
  modalRef: BsModalRef;
  dpConfig: Partial<BsDatepickerConfig> = new BsDatepickerConfig();

  carName: string; // carName should be equal to carBrand_carModel
  carDescription: string;
  carYear: number;
  pricePerDay: number;
  totalPrice: number;
  carImages: any[] = [];


  constructor(private modalService: BsModalService) { }

  openModal(modalCarDetails: TemplateRef<any>, currentCar: Car) {
    this.modalRef = this.modalService.show(modalCarDetails);
    this.setModalData(currentCar);
    console.log(currentCar);
  }

  setModalData(currentCar: Car) {
    this.carName = currentCar.brand + " " + currentCar.model;
    this.carDescription = currentCar.description;
    this.carYear = currentCar.year;
    this.pricePerDay = currentCar.pricePerDay;
    this.totalPrice = 0;
    this.carImages = currentCar.imgUrls;
  }

  calculateTotalPrice(numberOfDays: number, car: Car) {
    // Maybe add more business logic
    return numberOfDays * car.pricePerDay;
  }

  ngOnInit() {
    this.mockDataForFrontEnd();
    this.dpConfig.containerClass = 'theme-dark-blue';
  }


  // Mocking data

  mockDataForFrontEnd() {
    var car1 = new Car();
    var car2 = new Car();
    car1.imgUrls = [];
    car2.imgUrls = [];

    car1.brand = "Mercedes";
    car1.model = "S Class";
    car1.description = "Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis.";
    car1.pricePerDay = 200;
    car1.year = 2018;
    car1.imgUrls.push("../../assets/images/cars/mercedessclass.jpg");

    car2.brand = "Audi";
    car2.model = "A6";
    car2.description = "Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis.";
    car2.pricePerDay = 200;
    car2.year = 2018;
    car2.imgUrls.push("../../assets/images/cars/audia6.jpg");
    car2.imgUrls.push("../../assets/images/cars/audia62.jpg");

    this.cars.push(car1);
    this.cars.push(car2);
  }




}
