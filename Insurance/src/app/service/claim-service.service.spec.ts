import { TestBed, inject } from '@angular/core/testing';

import { ClaimServiceService } from './claim-service.service';

describe('ClaimServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ClaimServiceService]
    });
  });

  it('should be created', inject([ClaimServiceService], (service: ClaimServiceService) => {
    expect(service).toBeTruthy();
  }));
});
