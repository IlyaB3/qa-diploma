package ru.netology.page;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BuyingFormByCredit {
    private SelenideElement heading = $$("h3").findBy(Condition.exactText("Кредит по данным карты"));
    private SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("[placeholder='08']");
    private SelenideElement yearField = $("[placeholder='22']");
    private SelenideElement cardHolderField = $(byText("Владелец")).parent().$("[class='input__control']");
    private SelenideElement cvcField = $("[placeholder='999']");
    private SelenideElement button = $$("[class='button__content']").findBy(Condition.text("Продолжить"));
    private SelenideElement successNotification = $$("[class=notification__content]")
            .findBy(Condition.text("Операция одобрена Банком."));
    private SelenideElement errorNotification = $$("[class=notification__content]")
            .findBy(Condition.text("Ошибка! Банк отказал в проведении операции."));
    private SelenideElement wrongFormat = $$("[class=input__sub]").findBy(Condition.text("Неверный формат"));
    private SelenideElement wrongFormatForCardHolder = $$("[class=input__sub]")
            .findBy(Condition.text("Поле обязательно для заполнения"));
    private SelenideElement fieldMonthErrorWithInvalidValue = $$("[class=input__sub]")
            .findBy(Condition.text("Неверно указан срок действия карты"));
    private SelenideElement fieldYearErrorWithInvalidValue = $$("[class=input__sub]")
            .findBy(Condition.text("Неверно указан срок действия карты"));
    private SelenideElement wrongYearError = $$("[class=input__sub]")
            .findBy(Condition.text("Истёк срок действия карты"));

    public BuyingFormByCredit() {
        heading.shouldBe(Condition.visible);
    }

    public void inputDataByCredit(DataHelper.CardInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        cardHolderField.setValue(info.getCardHolder());
        cvcField.setValue(info.getCvc());
        button.click(ClickOptions.withTimeout(Duration.ofSeconds(15)));
    }

    public void waitSuccessfulNotificationForCreditField() {
        successNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void waitErrorNotificationForCreditField() {
        errorNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void waitNotificationWrongFormatForCreditForm() {
        wrongFormat.shouldBe(Condition.visible);
    }

    public void waitNotificationWrongFormatCardHolderForCreditForm() {
        wrongFormatForCardHolder.shouldBe(Condition.visible);
    }

    public void checkFieldMonthErrorWithInvalidValueForCreditForm() {
        fieldMonthErrorWithInvalidValue.shouldBe(Condition.visible);
    }

    public void checkFieldYearErrorWithInvalidValueForCreditForm() {
        fieldYearErrorWithInvalidValue.shouldBe(Condition.visible);
    }

    public void checkWrongYearErrorForCreditForm() {
        wrongYearError.shouldBe(Condition.visible);
    }
}