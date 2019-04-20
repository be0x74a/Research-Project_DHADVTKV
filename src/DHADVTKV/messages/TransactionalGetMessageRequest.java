package DHADVTKV.messages;

public class TransactionalGetMessageRequest extends Message {

    private final long key;
    private final long snapshot;
    private final int partition;
    private final int client;
    private final static long LENGTH = 16;
    private final static long CPU_TIME = 200;

    public TransactionalGetMessageRequest(long key, long snapshot, int client, int partition) {
        super(LENGTH, CPU_TIME);
        this.key = key;
        this.snapshot = snapshot;
        this.client = client;
        this.partition = partition;
    }


    public long getKey() {
        return key;
    }

    public long getSnapshot() {
        return snapshot;
    }

    public int getPartition() {
        return partition;
    }

    public int getClient() {
        return client;
    }
}