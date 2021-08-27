package org.nervos.mercury;

public interface RpcMethods {
  String GET_BALANCE = "get_balance";
  String GET_TRANSACTION_INFO = "get_transaction_info";
  String GET_BLOCK_INFO = "get_block_info";
  String QUERY_TRANSACTIONS = "query_transactions";
  String ADVANCE_QUERY = "advance_query";
  String BUILD_TRANSFER_TRANSACTION = "build_transfer_transaction";
  String BUILD_SMART_TRANSFER_TRANSACTION = "build_smart_transfer_transaction";
  String BUILD_ADJUST_ACCOUNT_TRANSACTION = "build_adjust_account_transaction";
  String BUILD_DEPOSIT_TRANSACTION = "build_deposit_transaction";
  String BUILD_WITHDRAW_TRANSACTION = "build_withdraw_transaction";
  String REGISTER_ADDRESSES = "register_addresses";
  String GET_MERCURY_INFO = "get_mercury_info";
  String GET_DB_INFO = "get_db_info";
  String GET_SPENT_TRANSACTION = "get_spent_transaction";
}
