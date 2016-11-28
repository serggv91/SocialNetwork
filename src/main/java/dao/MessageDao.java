package dao;


public interface MessageDao<E, K> extends Dao {
    E getBySenderId(K senderId);
    E getByRecipientId(K recipientId);
}
