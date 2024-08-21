<?php

namespace App\Repository;

use App\Entity\MessageUtilisateur;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @extends ServiceEntityRepository<MessageUtilisateur>
 */
class MessageUtilisateurRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, MessageUtilisateur::class);
    }

    //    /**
    //     * @return MessageUtilisateur[] Returns an array of MessageUtilisateur objects
    //     */
    //    public function findByExampleField($value): array
    //    {
    //        return $this->createQueryBuilder('m')
    //            ->andWhere('m.exampleField = :val')
    //            ->setParameter('val', $value)
    //            ->orderBy('m.id', 'ASC')
    //            ->setMaxResults(10)
    //            ->getQuery()
    //            ->getResult()
    //        ;
    //    }

    //    public function findOneBySomeField($value): ?MessageUtilisateur
    //    {
    //        return $this->createQueryBuilder('m')
    //            ->andWhere('m.exampleField = :val')
    //            ->setParameter('val', $value)
    //            ->getQuery()
    //            ->getOneOrNullResult()
    //        ;
    //    }


    public function getListConversation(int $idUser){


        $qb = $this->createQueryBuilder('m')
            ->select('DISTINCT u1.id AS utilisateur1Id, u2.id AS utilisateur2Id, u2.nom, u2.prenom')
            ->join('m.utilisateur2', 'u2')
            ->join('m.utilisateur1', 'u1')
            ->where('m.utilisateur1 = :utilisateur1Id')
            ->setParameter('utilisateur1Id', $idUser)
        ;

        return $qb->getQuery()->getResult();



        // return true;
    }

    public function getListMessagesConversation(int $idUser1, int $idUser2){
        $qb = $this->createQueryBuilder('m')
            ->select('m.id, m.contenu, m.dateHeureEnvoi, u1.id AS utilisateur1Id, u2.id AS utilisateur2Id')
            ->join('m.utilisateur2', 'u2')
            ->join('m.utilisateur1', 'u1')
            ->where('(m.utilisateur1 = :utilisateur1Id AND m.utilisateur2 = :utilisateur2Id)')
            ->orWhere('(m.utilisateur1 = :utilisateur2Id AND m.utilisateur2 = :utilisateur1Id)')
            ->setParameter('utilisateur1Id',$idUser1)
            ->setParameter('utilisateur2Id',$idUser2)
            ->orderBy('m.dateHeureEnvoi', 'DESC');

    return $qb->getQuery()->getResult();

    }



}
