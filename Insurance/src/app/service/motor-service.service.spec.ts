import { TestBed, inject } from '@angular/core/testing';

import { MotorServiceService } from './motor-service.service';

describe('MotorServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MotorServiceService]
    });
  });

  it('should be created', inject([MotorServiceService], (service: MotorServiceService) => {
    expect(service).toBeTruthy();
  }));
});
