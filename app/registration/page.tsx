"use client";

import * as yup from "yup";
import { useFormik } from "formik";

export default function Registration() {
  const basicSchema = yup.object().shape({
    name: yup.string().required("Это обязательное поле"),
    surname: yup.string().required("Это обязательное поле"),
    email: yup
      .string()
      .email("Введите корректный Email")
      .required("Это обязательное поле"),

    phoneNumber: yup.string().required("Это обязательное поле"),
    birthdayDate: yup.string().required("Это обязательное поле"),
  });

  const { values, errors, touched, isSubmitting, handleChange, handleSubmit } =
    useFormik({
      initialValues: {
        name: "",
        surname: "",
        email: "",
        phoneNumber: "",
        birthdayDate: "",
      },
      onSubmit: (values) => {
        console.log(values);
      },
      validationSchema: basicSchema,
    });

  return (
    <div className="">
      <form onSubmit={handleSubmit} className="">
        <h2 className="">Регистрация</h2>
        <div className="">
          <input
            className=""
            type="text"
            id="name"
            placeholder="Имя"
            onChange={handleChange}
            value={values.name}
          />
        </div>
        <div className="">
          <input
            className=""
            type="text"
            id="surname"
            placeholder="Фамилия"
            onChange={handleChange}
            value={values.surname}
          />
        </div>
        <div className="">
          <input
            className=""
            type="text"
            id="email"
            placeholder="Электронная почта"
            onChange={handleChange}
            value={values.email}
          />
        </div>
        <div className="">
          <input
            className=""
            type="text"
            id="phoneNumber"
            placeholder="Номер телефона"
            onChange={handleChange}
            value={values.phoneNumber}
          />
        </div>
        <div className="">
          <input
            className=""
            type="text"
            id="birthdayDate"
            placeholder="Дата рождения"
            onChange={handleChange}
            value={values.birthdayDate}
          />
        </div>
        <p className="">
          <input type="checkbox" /> Ознакомлен с политикой конфиденциальности
        </p>
        <button typeof="submit" className="">
          Зарегистрироваться
        </button>
      </form>
    </div>
  );
}
