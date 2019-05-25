export class Car {
  id: number;
  brand: string;
  model: string;
  year: number;
  description: string;
  imgUrls: any[];
  pricePerDay: number;

  public Car() {
    this.imgUrls = [];
  }
}

// May update model if needed
