import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewContractDetailComponent } from './add-new-contract-detail.component';

describe('AddNewContractDetailComponent', () => {
  let component: AddNewContractDetailComponent;
  let fixture: ComponentFixture<AddNewContractDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddNewContractDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNewContractDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
