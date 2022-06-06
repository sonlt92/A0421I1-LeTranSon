import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewContractComponent } from './add-new-contract.component';

describe('AddNewContractComponent', () => {
  let component: AddNewContractComponent;
  let fixture: ComponentFixture<AddNewContractComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddNewContractComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNewContractComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
