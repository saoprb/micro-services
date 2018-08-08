package com.sao.dentalappointment.appointment.usecase.interfaces;

public interface ICommand<T, S> {
    T execute(S s);
}
