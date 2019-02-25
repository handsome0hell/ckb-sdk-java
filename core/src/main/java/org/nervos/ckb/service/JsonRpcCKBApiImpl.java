package org.nervos.ckb.service;

import org.nervos.ckb.methods.Request;
import org.nervos.ckb.methods.response.*;
import org.nervos.ckb.methods.type.OutPoint;
import org.nervos.ckb.methods.type.Transaction;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by duanyytop on 2018-12-20.
 * Copyright © 2018 Nervos Foundation. All rights reserved.
 */
public class JsonRpcCKBApiImpl implements CKBService {

    protected final APIService apiService;

    public JsonRpcCKBApiImpl(APIService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Request<?, CkbBlock> getBlock(String blockHash) {
        return new Request<>(
                "get_block",
                Collections.singletonList(blockHash),
                apiService,
                CkbBlock.class);
    }


    @Override
    public Request<?, CkbTransaction> getTransaction(String transactionHash) {
        return new Request<>(
                "get_transaction",
                Collections.singletonList(transactionHash),
                apiService,
                CkbTransaction.class);
    }


    @Override
    public Request<?, CkbBlockHash> getBlockHash(long blockNumber) {
        return new Request<>(
                "get_block_hash",
                Collections.singletonList(blockNumber),
                apiService,
                CkbBlockHash.class);
    }


    @Override
    public Request<?, CkbHeader> getTipHeader() {
        return new Request<>(
                "get_tip_header",
                Collections.<String>emptyList(),
                apiService,
                CkbHeader.class);
    }


    @Override
    public Request<?, CkbCells> getCellsByTypeHash(String typeHash, long fromBlockNumber, long toBlockNumber) {
        return new Request<>(
                "get_cells_by_type_hash",
                Arrays.asList(typeHash, fromBlockNumber, toBlockNumber),
                apiService,
                CkbCells.class);
    }


    @Override
    public Request<?, CkbCell> getLiveCell(OutPoint outPoint) {
        return new Request<>(
                "get_live_cell",
                Collections.singletonList(outPoint),
                apiService,
                CkbCell.class);
    }

    @Override
    public Request<?, CkbBlockNumber> getTipBlockNumber() {
        return new Request<>(
                "get_tip_block_number",
                Collections.<String>emptyList(),
                apiService,
                CkbBlockNumber.class);
    }

    @Override
    public Request<?, CkbNodeInfo> localNodeInfo() {
        return new Request<>(
                "local_node_info",
                Collections.<String>emptyList(),
                apiService,
                CkbNodeInfo.class);
    }

    @Override
    public Request<?, CkbTransactionHash> sendTransaction(Transaction transaction) {
        return new Request<>(
                "send_transaction",
                Collections.singletonList(transaction),
                apiService,
                CkbTransactionHash.class);
    }


}
