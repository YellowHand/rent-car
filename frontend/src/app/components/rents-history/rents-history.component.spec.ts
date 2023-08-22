import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RentsHistoryComponent } from './rents-history.component';

describe('RentsHistoryComponent', () => {
  let component: RentsHistoryComponent;
  let fixture: ComponentFixture<RentsHistoryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RentsHistoryComponent]
    });
    fixture = TestBed.createComponent(RentsHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
