import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListUsingServiceComponent } from './list-using-service.component';

describe('ListUsingServiceComponent', () => {
  let component: ListUsingServiceComponent;
  let fixture: ComponentFixture<ListUsingServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListUsingServiceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListUsingServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
