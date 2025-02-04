<h1 align="center">Hi there, I'm <a>Ruzhalovich Ivan</a> 
<img src="https://github.com/blackcater/blackcater/raw/main/images/Hi.gif" height="32"/></h1>
<h2 align="center">Concurrency - многопоточный банковский счет</h2>
<h3 align="center">В виртуальном банке "ConcurrentBank" решено внедрить многопоточность для обработки операций по счетам клиентов. Система должна поддерживать возможность одновременного пополнения (deposit), снятия (withdraw), а также переводов (transfer) между счетами. Каждый счет имеет свой уникальный номер.Переводы между счетами должны быть атомарными, чтобы избежать ситуаций, когда одна часть транзакции выполняется успешно, а другая нет.</h3>
<h3 align="center">Реализован класс BankAccount с методами deposit, withdraw и getBalance, поддерживающими многопоточное взаимодействие.</h3>
<h3 align="center">Реализован класс ConcurrentBank для управления счетами и выполнения переводов между ними. Класс предоставляет методы createAccount для создания нового счета, transfer для выполнения переводов между счетами и getTotalBalance, который возвращает общий баланс всех счетов в банке.</h3>
# ConcurrencyMultithreadedBankAccount
